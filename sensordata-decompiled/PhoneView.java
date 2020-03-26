// 
// Decompiled by Procyon v0.5.36
// 

package se.hendeby.sensordata;

import java.awt.EventQueue;
import java.awt.AWTEvent;
import java.awt.Window;
import java.awt.event.WindowEvent;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.AmbientLight;
import java.awt.GraphicsConfiguration;
import javax.media.j3d.Bounds;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.Background;
import javax.vecmath.Point3d;
import java.awt.Component;
import javax.media.j3d.Canvas3D;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.media.j3d.ImageComponent2D;
import java.awt.image.BufferedImage;
import javax.media.j3d.TextureAttributes;
import javax.media.j3d.Texture;
import javax.media.j3d.ImageComponent;
import javax.media.j3d.Texture2D;
import com.sun.j3d.utils.image.TextureLoader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.vecmath.TexCoord2f;
import javax.media.j3d.Geometry;
import javax.media.j3d.Shape3D;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Material;
import javax.vecmath.Vector3f;
import javax.vecmath.Point3f;
import javax.media.j3d.IndexedQuadArray;
import com.sun.j3d.utils.geometry.Cone;
import javax.vecmath.Vector3d;
import com.sun.j3d.utils.geometry.Cylinder;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.Appearance;
import javax.media.j3d.Node;
import javax.vecmath.Color3f;
import javax.vecmath.Quat4d;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JFrame;

public class PhoneView extends JFrame
{
    private static final long serialVersionUID = 1L;
    private TransformGroup transGroup_;
    private TransformGroup viewTransform_;
    
    public void setRotation(final double w, final double x, final double y, final double z) {
        final Transform3D rot = new Transform3D();
        rot.setRotation(new Quat4d(x, y, z, w));
        this.transGroup_.setTransform(rot);
    }
    
    private Node createAxis(final Color3f color, final Quat4d orientation, final float length) {
        final float r = 0.1f;
        final TransformGroup axis = new TransformGroup();
        Transform3D align = new Transform3D();
        align.setRotation(orientation);
        axis.setTransform(align);
        final Appearance c = new Appearance();
        c.setColoringAttributes(new ColoringAttributes(color, 2));
        axis.addChild((Node)new Cylinder(0.1f, length, c));
        final TransformGroup hatTranslation = new TransformGroup();
        align = new Transform3D();
        align.setTranslation(new Vector3d(0.0, (double)(length / 2.0f), 0.0));
        hatTranslation.addChild((Node)new Cone(0.2f, 0.3f, c));
        hatTranslation.setTransform(align);
        axis.addChild((Node)hatTranslation);
        return (Node)axis;
    }
    
    private Node createPhone() {
        final float height = 5.275f;
        final float width = 2.7f;
        final float depth = 0.35f;
        final IndexedQuadArray indexedCube = new IndexedQuadArray(8, 3, 24);
        final Point3f[] cubeCoordinates = { new Point3f(1.35f, 2.6375f, 0.175f), new Point3f(-1.35f, 2.6375f, 0.175f), new Point3f(-1.35f, -2.6375f, 0.175f), new Point3f(1.35f, -2.6375f, 0.175f), new Point3f(1.35f, 2.6375f, -0.175f), new Point3f(-1.35f, 2.6375f, -0.175f), new Point3f(-1.35f, -2.6375f, -0.175f), new Point3f(1.35f, -2.6375f, -0.175f) };
        final Vector3f[] normals = { new Vector3f(0.0f, 0.0f, 1.0f), new Vector3f(0.0f, 0.0f, -1.0f), new Vector3f(1.0f, 0.0f, 0.0f), new Vector3f(-1.0f, 0.0f, 0.0f), new Vector3f(0.0f, 1.0f, 0.0f), new Vector3f(0.0f, -1.0f, 0.0f) };
        final int[] coordIndices = { 0, 1, 2, 3, 7, 6, 5, 4, 0, 3, 7, 4, 5, 6, 2, 1, 0, 4, 5, 1, 6, 7, 3, 2 };
        final int[] normalIndices = { 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5 };
        indexedCube.setCoordinates(0, cubeCoordinates);
        indexedCube.setNormals(0, normals);
        indexedCube.setCoordinateIndices(0, coordIndices);
        indexedCube.setNormalIndices(0, normalIndices);
        final Appearance app = new Appearance();
        final Color3f ambientColor = new Color3f(0.1f, 0.1f, 0.1f);
        final Color3f emissiveColor = new Color3f(0.2f, 0.2f, 0.2f);
        final Color3f specularColor = new Color3f(0.9f, 0.9f, 0.9f);
        final Color3f diffuseColor = new Color3f(0.0f, 0.0f, 0.0f);
        final float shininess = 100.0f;
        app.setMaterial(new Material(ambientColor, emissiveColor, diffuseColor, specularColor, shininess));
        final BranchGroup root = new BranchGroup();
        final Shape3D cube = new Shape3D((Geometry)indexedCube, app);
        root.addChild((Node)cube);
        final IndexedQuadArray indexedScreen = new IndexedQuadArray(4, 35, 4);
        final Point3f[] screenCoordinates = { new Point3f(1.15f, 2.4375f, 0.176f), new Point3f(-1.15f, 2.4375f, 0.176f), new Point3f(-1.15f, -2.0375f, 0.176f), new Point3f(1.15f, -2.0375f, 0.176f) };
        final Vector3f[] screennormal = { new Vector3f(0.0f, 0.0f, 1.0f) };
        final TexCoord2f[] texCoords = { new TexCoord2f(1.0f, 1.0f), new TexCoord2f(0.0f, 1.0f), new TexCoord2f(0.0f, 0.0f), new TexCoord2f(1.0f, 0.0f) };
        final int[] screencoordIndices = { 0, 1, 2, 3 };
        final int[] screennormalIndices = { 0, 0, 0, 0 };
        final int[] texIndices = { 0, 1, 2, 3 };
        indexedScreen.setCoordinates(0, screenCoordinates);
        indexedScreen.setNormals(0, screennormal);
        indexedScreen.setTextureCoordinates(0, 0, texCoords);
        indexedScreen.setCoordinateIndices(0, screencoordIndices);
        indexedScreen.setNormalIndices(0, screennormalIndices);
        indexedScreen.setTextureCoordinateIndices(0, 0, texIndices);
        BufferedImage img = null;
        try {
            img = ImageIO.read(PhoneView.class.getResource("/res/drawable/screenContent.png"));
        }
        catch (IOException ex) {}
        final TextureLoader textLoad = new TextureLoader(img);
        final ImageComponent2D textImage = textLoad.getImage();
        final Texture2D texture = new Texture2D(1, 5, textImage.getWidth(), textImage.getHeight());
        texture.setImage(0, (ImageComponent)textImage);
        final Appearance screenApp = new Appearance();
        screenApp.setTexture((Texture)texture);
        final TextureAttributes textAttr = new TextureAttributes();
        textAttr.setTextureMode(5);
        screenApp.setTextureAttributes(textAttr);
        screenApp.setMaterial(new Material());
        root.addChild((Node)new Shape3D((Geometry)indexedScreen, screenApp));
        root.addChild(this.createAxis(new Color3f(0.0f, 1.0f, 0.0f), new Quat4d(0.0, 0.0, -1.0, 1.0), 4.2f));
        root.addChild(this.createAxis(new Color3f(0.0f, 0.0f, 1.0f), new Quat4d(0.0, 0.0, 0.0, 1.0), 6.775f));
        root.addChild(this.createAxis(new Color3f(1.0f, 0.0f, 0.0f), new Quat4d(1.0, 0.0, 0.0, 1.0), 1.85f));
        root.compile();
        return (Node)root;
    }
    
    public PhoneView() {
        this.setSize(300, 300);
        this.getContentPane().setLayout(new BorderLayout());
        final GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        final Canvas3D canvas3D = new Canvas3D(config);
        this.setSize(300, 300);
        this.getContentPane().add((Component)canvas3D);
        final SimpleUniverse universe = new SimpleUniverse(canvas3D);
        final Transform3D viewTransform = new Transform3D();
        viewTransform.lookAt(new Point3d(0.0, -15.0, 0.0), new Point3d(0.0, 0.0, 0.0), new Vector3d(0.0, 0.0, 1.0));
        viewTransform.invert();
        (this.viewTransform_ = universe.getViewingPlatform().getViewPlatformTransform()).setTransform(viewTransform);
        final BranchGroup root = new BranchGroup();
        this.addLights(root);
        (this.transGroup_ = new TransformGroup()).setCapability(18);
        root.addChild((Node)this.transGroup_);
        final Background background = new Background(new Color3f(0.9f, 0.9f, 1.0f));
        final BoundingSphere sphere = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100000.0);
        background.setApplicationBounds((Bounds)sphere);
        root.addChild((Node)background);
        this.transGroup_.addChild(this.createPhone());
        universe.addBranchGraph(root);
    }
    
    protected void addLights(final BranchGroup b) {
        final BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
        final Color3f lightColor = new Color3f(0.9f, 0.9f, 1.0f);
        final Vector3f lightDir = new Vector3f(-1.0f, -1.0f, -1.0f);
        final Color3f ambientColor = new Color3f(0.2f, 0.2f, 0.2f);
        final AmbientLight ambientLight = new AmbientLight(ambientColor);
        ambientLight.setInfluencingBounds((Bounds)bounds);
        final DirectionalLight directionalLight = new DirectionalLight(lightColor, lightDir);
        directionalLight.setInfluencingBounds((Bounds)bounds);
        b.addChild((Node)ambientLight);
        b.addChild((Node)directionalLight);
    }
    
    public static void main(final String[] args) {
        final PhoneView cV = new PhoneView();
        cV.setVisible(true);
        cV.setDefaultCloseOperation(3);
        final SensorDataReader reader = new StreamSensorDataReader(3400);
        final EstimateOrientation est = new EstimateOrientation(reader);
        try {
            est.start();
            while (est.status()) {
                final double[] quat = est.getQuat();
                cV.setRotation(quat[0], quat[1], quat[2], quat[3]);
                try {
                    Thread.sleep(10L);
                }
                catch (InterruptedException ex) {}
            }
        }
        catch (IOException ex2) {}
        finally {
            try {
                est.stop();
            }
            catch (IOException ex3) {}
        }
        if (cV != null) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    cV.dispatchEvent(new WindowEvent(cV, 201));
                }
            });
        }
    }
}
