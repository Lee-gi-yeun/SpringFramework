package com.ohgiraffers.section01.autowired.subsection03.setter;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// component scan 을 통해 bean 등록, bookServiceField가 bean name
@Service("bookServiceSetter")
public class BookService {

    private BookDAO bookDAO;

    // 의존성 주입이 옵션으로 수행 될 수 있도록 처리하는데 유용하게 사용됨
    @Autowired(required = false)
    public void setBookDAO(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> selectAllBooks(){
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence){
        return bookDAO.selectOneBook(sequence);
    }
}
