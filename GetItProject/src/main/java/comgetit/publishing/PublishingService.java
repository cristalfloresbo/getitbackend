package comgetit.publishing;

import comgetit.publishing.dto.PublicationsDTO;
import comgetit.publishing.dto.PublishingDTO;
import comgetit.publishing.exception.PublishingTypeException;
import comgetit.workarea.WorkArea;
import comgetit.workarea.WorkAreaRepository;
import comgetit.workarea.exception.WorkAreNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishingService {

    private final PublishingRepository publishingRepository;

    private final WorkAreaRepository workAreaRepository;

    @Autowired
    public PublishingService(
        PublishingRepository publishingRepository, WorkAreaRepository workAreaRepository) {
        this.publishingRepository = publishingRepository;
        this.workAreaRepository = workAreaRepository;
    }

    public Publishing createPublishing(final PublishingDTO publishingDTO) {
        WorkArea workArea = workAreaRepository.findById(publishingDTO.getWorkAreaId())
            .orElseThrow(WorkAreNotFoundException::new);
        PublishingType publishingType = convertToTypePublishing(publishingDTO.getTypePublishing());
        Publishing publishing = new Publishing();
        publishing.setPublishingType(publishingType);
        publishing.setWorkArea(workArea);
        publishing.setTariff(publishingDTO.getTariff());
        publishing.setAddress(publishingDTO.getAddress());
        publishing.setTimeRequiredOrOffered(publishingDTO.getTimeRequiredOrOffered());
        publishing.setDescription(publishingDTO.getDescription());
        return publishingRepository.save(publishing);
    }

    public PublishingType convertToTypePublishing(String typePublishing) {
        try {
            return PublishingType.valueOf(typePublishing);
        } catch (IllegalArgumentException exception) {
            throw new PublishingTypeException(typePublishing);
        }
    }
    
    public List<PublicationsDTO> getAllPublications() {
        return publishingRepository.findAll().stream()
            .map(publication -> new PublicationsDTO(publication.getId(), publication.getPublishingType(), 
            					publication.getWorkArea(), publication.getTariff(),
            					publication.getAddress(), publication.getTimeRequiredOrOffered(), 
            					publication.getDescription()))
            		.collect(Collectors.toList());
    }
    
   
}
