package com.esprit.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.quiz.entity.Commentaire;


@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {

	Commentaire findByIdentifiant(String paramString);

}
