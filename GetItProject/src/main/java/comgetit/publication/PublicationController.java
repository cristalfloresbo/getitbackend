package comgetit.publication;

import comgetit.publication.dto.PublicationDTO;
import comgetit.user.User;
import comgetit.publication.dto.PublicationCreationDTO;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicationController {

    private PublicationService publicationService;

    @Autowired
    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @PostMapping("/publication")
    public ResponseEntity<Long> createPublication(
        @RequestBody @Valid final PublicationCreationDTO publicationCreationDTO
    ) {
        Publication publication = publicationService.createPublication(publicationCreationDTO);
        return new ResponseEntity(publication.getId(), HttpStatus.CREATED);
    }
    
    @GetMapping("/publications")
    public List<PublicationDTO> getAllPublications() {
        return publicationService.getAllPublications();
    }

    @GetMapping("/publications/search")
    public List<PublicationDTO> searchByWorkArea(@RequestParam("workarea") String workAreaName) {
        return publicationService.searchByWorkArea(workAreaName);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/publication/{id}")
    public Optional<Publication> getPublicationById(@PathVariable Long id) {
        return publicationService.getPublication(id);
    }
}
