package com.massivedisaster.tdengine;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

import java.io.File;

public class TDEngine extends ApplicationAdapter {

	private String vertShader;
	private String fragShader;

	public TDEngine() {
	}

	protected static ShaderProgram createMeshShader(String vertShader, String fragShader) {
		ShaderProgram.pedantic = false;
		ShaderProgram shader = new ShaderProgram(vertShader, fragShader);
		String log = shader.getLog();
		if (!shader.isCompiled())
			throw new RuntimeException(log);
		if (log!=null && log.length()!=0)
			System.out.println("Shader Log: "+log);
		return shader;
	}

	Mesh mesh;
	OrthographicCamera cam;
	ShaderProgram shader;

	//Position attribute - (x, y)
	public static final int POSITION_COMPONENTS = 2;

	//Color attribute - (r, g, b, a)
	public static final int COLOR_COMPONENTS = 4;

	//Total number of components for all attributes
	public static final int NUM_COMPONENTS = POSITION_COMPONENTS + COLOR_COMPONENTS;

	//The maximum number of triangles our mesh will hold
	public static final int MAX_TRIS = 1;

	//The maximum number of vertices our mesh will hold
	public static final int MAX_VERTS = MAX_TRIS * 3;

	//The array which holds all the data, interleaved like so:
	//    x, y, r, g, b, a
	//    x, y, r, g, b, a,
	//    x, y, r, g, b, a,
	//    ... etc ...
	private float[] verts = new float[MAX_VERTS * NUM_COMPONENTS];

	//The index position
	private int idx = 0;

	@Override
	public void create() {

		final ClassLoader classLoader = TDEngine.class.getClassLoader();

		System.out.println(Gdx.files);
		vertShader = Gdx.files.internal("shaders/VertexShader.glsl").readString(); //new FileHandle(new File(classLoader.getResource("shaders/VertexShader.glsl").getFile()));
		fragShader = Gdx.files.internal("shaders/FragmentShader.glsl").readString(); //new FileHandle(new File(classLoader.getResource("shaders/FragmentShader.glsl").getFile()));


		mesh = new Mesh(true, MAX_VERTS, 0,
				new VertexAttribute(1, POSITION_COMPONENTS, "a_position"),
				new VertexAttribute(2, COLOR_COMPONENTS, "a_color"));

		shader = createMeshShader(vertShader, fragShader);
		cam = new OrthographicCamera();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//this will push the triangles into the batch
		drawTriangle(10, 10, 40, 40, Color.RED);
		drawTriangle(50, 50, 70, 40, Color.BLUE);

		//this will render the triangles to GL
		flush();
	}

	void flush() {
		//if we've already flushed
		if (idx==0)
			return;

		//sends our vertex data to the mesh
		mesh.setVertices(verts);

		//no need for depth...
		Gdx.gl.glDepthMask(false);

		//enable blending, for alpha
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

		//number of vertices we need to render
		int vertexCount = (idx/NUM_COMPONENTS);

		//update the camera with our Y-up coordiantes
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		//start the shader before setting any uniforms
		shader.begin();

		//update the projection matrix so our triangles are rendered in 2D
		shader.setUniformMatrix("u_projTrans", cam.combined);

		//render the mesh
		mesh.render(shader, GL20.GL_TRIANGLES, 0, vertexCount);

		shader.end();

		//re-enable depth to reset states to their default
		Gdx.gl.glDepthMask(true);

		//reset index to zero
		idx = 0;
	}

	void drawTriangle(float x, float y, float width, float height, Color color) {
		//we don't want to hit any index out of bounds exception...
		//so we need to flush the batch if we can't store any more verts
		if (idx==verts.length)
			flush();

		//now we push the vertex data into our array
		//we are assuming (0, 0) is lower left, and Y is up

		//bottom left vertex
		verts[idx++] = x; 			//Position(x, y)
		verts[idx++] = y;
		verts[idx++] = color.r; 	//Color(r, g, b, a)
		verts[idx++] = color.g;
		verts[idx++] = color.b;
		verts[idx++] = color.a;

		//top left vertex
		verts[idx++] = x; 			//Position(x, y)
		verts[idx++] = y + height;
		verts[idx++] = color.r; 	//Color(r, g, b, a)
		verts[idx++] = color.g;
		verts[idx++] = color.b;
		verts[idx++] = color.a;

		//bottom right vertex
		verts[idx++] = x + width;	 //Position(x, y)
		verts[idx++] = y;
		verts[idx++] = color.r;		 //Color(r, g, b, a)
		verts[idx++] = color.g;
		verts[idx++] = color.b;
		verts[idx++] = color.a;
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		mesh.dispose();
		shader.dispose();
	}
}
