package de.ibm.openshift.notes;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotesController {
    @Autowired
    private NotesRepository notesRepository;

    @GetMapping("/notes")
    public Iterable<Notes> findAllNotes() {
        return this.notesRepository.findAll();
    }

    @GetMapping("/notes/{id}")
    public Notes findOneNotes(@PathVariable("id") Integer id) {
        return this.notesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @PostMapping("/notes")
    public Notes addNotes(@RequestBody Notes notes) {
        return this.notesRepository.save(notes);
    }
}
