import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formation.virgin.entity.Album;
import com.formation.virgin.manager.MagasinManager;

@Controller
@RequestMapping("/listAlbums")

public class AlbumController {
	@RequestMapping(method = RequestMethod.GET)
	public String printClient(final ModelMap model) {
		final ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		
		final MagasinManager magasinManager = (MagasinManager) ctx
				.getBean("magasinManagerImpl");
		
		final List<Album> list = magasinManager.getAlbums();
		
		model.addAttribute("albums", list);
		return null;
	}
	
		

}
