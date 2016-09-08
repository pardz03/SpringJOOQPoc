import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.poc.dao.repository.ImageRepository;
import com.poc.dto.DataTransferObject;
import com.poc.model.Image;
import com.poc.service.ImageService;


public class ImageTest extends BaseTestRunner{
	@Autowired
	private ImageService iservice;
	
	@Test
	public void testImage(){
		DataTransferObject dto = new DataTransferObject();
		DataTransferObject fetchResult = iservice.selectImage(dto);
		
		for(Image i : fetchResult.getImagelist()){
			System.out.println(i.getId());
			System.out.println(i.getName());
			System.out.println(i.getPath());
		}
	}
}
