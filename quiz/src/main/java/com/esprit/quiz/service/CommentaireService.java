package com.esprit.quiz.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.quiz.entity.Commentaire;
import com.esprit.quiz.entity.Like;
import com.esprit.quiz.entity.User;
import com.esprit.quiz.entity.WrongWords;
import com.esprit.quiz.repository.CommentaireRepository;
import com.esprit.quiz.repository.LikeRepository;


@Service
public class CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserService userservice;

    @Autowired
    private WrongWordsService wrongWordsService;

    public String addCommentaire(int id, Commentaire commentaire) throws Exception {
        User user = userservice.findById(id);
        String contenu = commentaire.getContenu();
        if (!contenu.isEmpty() && !checkWrongWords(contenu)) {
            return " Comment Contains wrong word ";
        }
        commentaire.setDateDeCreation(new Date());
        commentaire.setAuteur(user);
        commentaireRepository.save(commentaire);
        return "Comment saved";
    }

    public String deleteCommentaire(int id) {
        User user = userservice.findById(id);
        Commentaire commentaire = commentaireRepository.findById(id).get();
        User auteur = commentaire.getAuteur();
        if (auteur.getId() == user.getId()) {
            commentaireRepository.deleteById(id);
            return "Comment Deleted";
        } else
            return "Permission denied";
    }

    public String updateCommentaire(int id, Commentaire newCommentaire) {
        User user = userservice.findById(id);
        String contenu = newCommentaire.getContenu();
        if (!contenu.isEmpty() && !checkWrongWords(contenu)) {
            return "New Comment Contains wrong word ";
        }
        Commentaire commentaire = commentaireRepository.findById(id).get();
        User auteur = commentaire.getAuteur();
        if (auteur.getId() == user.getId()) {
            commentaire.setDateDeModification(new Date());
            commentaire.setContenu(newCommentaire.getContenu());
            commentaireRepository.save(commentaire);
            return "Comment Updated";
        } else
            return "Comment not Updated , you are not the author";

    }

    public List<Commentaire> getAllCommentaire() {
        List<Commentaire> Commentaires = commentaireRepository.findAll();
        return Commentaires;
    }

    public String likeCommentaire(int id) throws Exception {
        User user = userservice.findById(id);
        Commentaire commentaire = commentaireRepository.findById(id).get();
        Boolean likeExist = likeRepository.existsByUserIdAndCommentId(user.getId(), commentaire.getIdentifiant());
        if (likeExist) {
            return "Alrady Liked";
        } else {
            Like newCommentLike = new Like();
            newCommentLike.setCommentId(id);
            newCommentLike.setUserId(user.getId());
            newCommentLike.setLiked(true);
            likeRepository.save(newCommentLike);
            commentaire.setNombreLike(commentaire.getNombreLike() + 1);
            commentaireRepository.save(commentaire);
            return "Liked";
        }
    }

    public String dislikeCommentaire(int id) throws Exception {
        User user = userservice.findById(id);
        Commentaire commentaire = commentaireRepository.findById(id).get();
        Boolean likeExist = likeRepository.existsByUserIdAndCommentId(user.getId(), commentaire.getIdentifiant());
        if (likeExist) {
            likeRepository.deleteByUserIdAndCommentId(user.getId(), commentaire.getIdentifiant());
            commentaire.setNombreLike(commentaire.getNombreLike() - 1);
            commentaireRepository.save(commentaire);
            return " DisLiked";
        } else {
            return "Alrady DisLiked";
        }
    }

    private boolean checkWrongWords(String contenu) {
        List<WrongWords> wrongWords = wrongWordsService.getAllWrongWords();
        Iterator<?> iterator = wrongWords.iterator();
        while (iterator.hasNext()) {
            WrongWords wrongWord = (WrongWords) iterator.next();
            if (contenu.contains(wrongWord.getWord())) {
                return false;
            }
        }
        return true;
    }

}
