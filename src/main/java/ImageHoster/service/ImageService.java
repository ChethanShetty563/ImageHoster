package ImageHoster.service;

import ImageHoster.HardCodedImage;
import ImageHoster.model.Image;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ImageService {
    HardCodedImage hardCodedImage = new HardCodedImage();
    private List<Image> images = new ArrayList<>();

    public ImageService() {
        Date date = new Date();
        images.add(new Image(1, "Dr. Strange", hardCodedImage.getDrStrange(),date));
        images.add(new Image(2, "SpiderMan", hardCodedImage.getSpiderMan(),date));
    }

    public void uploadImage(Image image) {
        return;
    }

    public List<Image> getAllImages() {
        return new ImageService().images;
    }
}
