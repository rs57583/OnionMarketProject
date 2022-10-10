package com.youprice.onion.repository.member;


import com.youprice.onion.entity.member.Keyword;
import com.youprice.onion.entity.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


public interface KeywordRepositoy extends JpaRepository<Keyword,Long> {


    public List<Keyword> findByKeywordNameOrKeywordName(String subject,String productName);

    public Keyword findByKeywordNameAndMember(String name , Member id);



    @Repository
    @RequiredArgsConstructor


    public class Keywordrepositoy {


        private final EntityManager em;


        public List<Keyword> findKeywordList(String userId) {

            return em.createQuery("select o from Keyword o join fetch o.member where o.member.userId = :userId ", Keyword.class)
                    .setParameter("userId", userId)
                    .getResultList();

        }

        public List<Keyword> keywordalram(String subject,String productName){ //상품등록시 키워드알림

            return em.createQuery("select m from Keyword m where m.keywordName= :subject or m.keywordName =:productName",Keyword.class)
                    .setParameter("subject", subject)
                    .setParameter("productName", productName)
                    .getResultList();

        }


//        @Transactional
//        public int updatecount(String subject,String productName) {
//            return em.createQuery("update Keyword as m " +
//                            "set m.alram = m.alram+1 where m.keywordName = :subject or m.keywordName = :productName")
//                    .setParameter("subject", subject)
//                    .setParameter("productName", productName)
//                    .executeUpdate();
//        }





    }

}