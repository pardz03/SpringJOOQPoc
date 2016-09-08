import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.poc.dao.ImageRepository;


public class ImageTest extends BaseTestRunner{
	@Autowired
	private ImageRepository imageRepository;
	
	@Test
	public void testImage(){
		imageRepository.select();
	}
}
