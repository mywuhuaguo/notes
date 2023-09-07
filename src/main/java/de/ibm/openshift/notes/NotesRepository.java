package de.ibm.openshift.notes;

import org.springframework.data.repository.CrudRepository;

public interface NotesRepository extends CrudRepository<Notes, Integer> {}