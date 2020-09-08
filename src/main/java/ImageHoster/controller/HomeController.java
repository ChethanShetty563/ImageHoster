package ImageHoster.controller;


import ImageHoster.model.Image;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ImageService imageService;

    @RequestMapping("/")
    public String getImages(Model model) throws ClassNotFoundException{
       List<Image> images =  imageService.getAllImages();
       model.addAttribute("images",images);
        return "index";
    }


}
