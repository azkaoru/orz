package java8extra;

import java.io.File;
import java.util.zip.ZipFile;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public class TestUtil {

	private static final String LOCAL_MAVEN_REPO = System.getProperty("maven.repo.local") != null ? System
			.getProperty("maven.repo.local") : (System.getProperty("user.home") + File.separatorChar + ".m2"
			+ File.separatorChar + "repository");
			
//	public static JavaArchive create() {
//		try {
//			File artifactFile = new File(LOCAL_MAVEN_REPO,
//					"wildfly/lab/java8extra/0.1-SNAPSHOT/java8extra-0.1-SNAPSHOT.jar");
//			return ShrinkWrap.create(ZipImporter.class, "java8extra-0.1-SNAPSHOT.jar")
//					.importFrom(new ZipFile(artifactFile)).as(JavaArchive.class);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
	
	public static WebArchive archiveDeploymentForDBclean() {
		try {
			File artifactFile = new File(LOCAL_MAVEN_REPO,
					"wildfly/lab/java8extra/0.1-SNAPSHOT/java8extra-0.1-SNAPSHOT.war");
			return ShrinkWrap.create(ZipImporter.class, "java8extra-0.1-SNAPSHOT.war")
					.importFrom(new ZipFile(artifactFile)).as(WebArchive.class).addAsResource("META-INF/persistence-create.xml",
							"META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
							.addAsWebInfResource("web.xml");
							
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static WebArchive archiveDeploymentForDBupdate() {
		try {
			File artifactFile = new File(LOCAL_MAVEN_REPO,
					"wildfly/lab/java8extra/0.1-SNAPSHOT/java8extra-0.1-SNAPSHOT.war");
			return ShrinkWrap.create(ZipImporter.class, "java8extra-0.1-SNAPSHOT.war")
					.importFrom(new ZipFile(artifactFile)).as(WebArchive.class).addAsResource("META-INF/persistence-update.xml",
							"META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
							.addAsWebInfResource("web.xml");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
