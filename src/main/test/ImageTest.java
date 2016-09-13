import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.poc.dao.repository.ImageRepository;
import com.poc.dto.DataTransferObject;
import com.poc.model.Image;
import com.poc.service.ImageService;


public class ImageTest extends BaseTestRunner{
	@Autowired
	private ImageService iservice;
	

	public void testImage(){
		DataTransferObject dto = new DataTransferObject();
		DataTransferObject fetchResult = iservice.selectImage(dto);
		
		for(Image i : fetchResult.getImagelist()){
			System.out.println(i.getId());
			System.out.println(i.getName());
			System.out.println(i.getPath());
		}
	}
	

	public void testImageSave(){
		DataTransferObject dto = new DataTransferObject();
		Image i = new Image();
		i.setName("JOOQ SAVE2");
		i.setPath("JOOQ PATH2");
		dto.setImage(i);
		iservice.saveImage(dto);
	}
	

	public void testImageUpdate(){
		DataTransferObject dto = new DataTransferObject();
		Image i = new Image();
		i.setName("JOOQ updatename");
		i.setPath("JOOQ UPDATEPATH");
		i.setId("24");
		dto.setImage(i);
		iservice.updateImage(dto);
	}
	
	@Test
	public void testDeleteImage(){
		DataTransferObject dto = new DataTransferObject();
		Image i = new Image();
		i.setId("25");
		dto.setImage(i);
		iservice.deleteImage(dto);
	}
}
