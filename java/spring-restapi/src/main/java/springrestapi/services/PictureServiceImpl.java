package springrestapi.services;

import springrestapi.domain.user.resources.Picture;
import springrestapi.repositories.users.PictureRepository;

public class PictureServiceImpl extends ReadWriteServiceImpl<Picture, String> implements PictureService {
    public PictureServiceImpl(PictureRepository repository) {
        super(repository);
    }
}
