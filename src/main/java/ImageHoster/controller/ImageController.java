package ImageHoster.controller;

import ImageHoster.HardCodedImage;
import ImageHoster.model.Image;
import ImageHoster.service.ImageService;
//import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
//import sun.text.normalizer.NormalizerBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private HardCodedImage hardCodedImage;

    @RequestMapping(value = "images")
    public String getUserImages(Model model) {
        List<Image> images = imageService.getAllImages();
        model.addAttribute("images",images);
        return "images";
    }

    @RequestMapping("/images/{title}")
    public String showImage(@PathVariable("title") String title, Model model) {
        Date date =  new Date();
        Image image = null;
        if(title.equals("Dr. Strange")) {
            image = new Image(1,"Dr. Strange",hardCodedImage.getDrStrange(),"Dr.Strange has a time stone",date);
        }
        else if(title.equals("SpiderMan")) {
            image = new Image(2,"SpiderMan",hardCodedImage.getSpiderMan(),"Spider man dies in Infinity War",date);
        }
        model.addAttribute("image",image);
        return "images/image";

    }

    @RequestMapping("/images/upload")
    public String newImage() {
        return "images/upload";

    }

    @RequestMapping(value = "/images/upload",method= RequestMethod.POST)
    public String createImage(@RequestParam("file")MultipartFile file, Image newImage) throws IOException {

        String i = convertUploadedFileTBase64(file);
        newImage.setImageFile(i);
        newImage.setDate(new Date());
        imageService.uploadImage(newImage);

        return "redirect:/images";

    }

    private String convertUploadedFileTBase64(MultipartFile file) throws IOException {
        return Base64.getEncoder().encodeToString(file.getBytes());
    }
}
