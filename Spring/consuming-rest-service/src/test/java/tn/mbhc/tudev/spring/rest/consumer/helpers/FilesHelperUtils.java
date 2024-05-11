package tn.mbhc.tudev.spring.rest.consumer.helpers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * Helper class to manage files needed for tests.
 */
public final class FilesHelperUtils {

	/**
	 * Return the content of the given file as String, using the UTF-8 charset.
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String getStringContentFromFileWithUtf8Charset(final String fileName) throws IOException {
		return getStringContentFromFile(fileName, Charset.forName("UTF-8"));
	}
	
	/**
	 * Return the content of the given file as String, using the given charset.
	 * @param file
	 * @param charset
	 * @return
	 * @throws IOException
	 */
	public static String getStringContentFromFile(final String fileName, final Charset charset) throws IOException {
		File file = FilesHelperUtils.loadFile(fileName);
		return new String(Files.readAllBytes(file.toPath()), charset);
	}
	
	/**
	 * Creats a {@link File} from the given fileName.
	 * 
	 * @param fileName
	 * @return
	 * @throws IllegalArgumentException if the given filename is not a valid
	 *                                  resource
	 */
	public static final File loadFile(final String fileName) throws IllegalArgumentException {
		URL resourceUrl = FilesHelperUtils.class.getClassLoader().getResource(fileName);
		if (resourceUrl == null) {
			throw new IllegalArgumentException(
					String.format("Cannot load a file from a null resource (fileName : %s)", fileName));
		}
		return new File(resourceUrl.getFile());
	}

	private FilesHelperUtils() {
		// Files utility class, no need to instanciate
	}
}
