package com.youprice.onion.entity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "product_id")
    private Long id; //상품번호 PK

    private String productName; //상품명

    private String subject; //제목

    private String content; //내용

    private int price; //상품가격

    private LocalDateTime uploadDate; //등록일

    private LocalDateTime updateDate; //수정일

    private int viewCount; //조회수

    @Enumerated(EnumType.STRING)
    private ProductProgress productProgress; //판매상태 Reserved,tradings,soldout 예약중,거래중,판매완료

    private String payStatus; //페이현황
    
    private String auctionStatus; //경매현황
    
    private String blindStatus; //블라인드현황

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;//회원번호 FK

    @OneToMany(mappedBy = "product")//카테고리번호 FK
    private List<ProductCategory> productCategoryList = new ArrayList<>();

    @OneToMany(mappedBy = "product")//이미지번호
    private List<ProductImg> productImgList = new ArrayList<>();

    @OneToMany(mappedBy = "product")//키워드번호
    private List<Keyword> keywordList = new ArrayList<>();

    @OneToMany(mappedBy = "product")//태그번호
    private List<ProductTag> productTagList = new ArrayList<>();

    @OneToOne(mappedBy = "product")//카운트번호
    private  Countdown countdown;


}













