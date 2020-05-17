package com.example.bookback.serviceimpl;

import com.example.bookback.dao.BookDao;
import com.example.bookback.dao.OrderItemDao;
import com.example.bookback.dao.TypeDao;
import com.example.bookback.daoimpl.OrderItemDaoImpl;
import com.example.bookback.entity.Book;
import com.example.bookback.entity.Type;
import com.example.bookback.service.BookService;
import com.example.bookback.utils.msgutils.Msg;
import com.example.bookback.utils.msgutils.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private TypeDao typeDao;

    @Override
    public Book findBookById(Integer id){
        return bookDao.findOne(id);
    }

    @Override
    public List<Book> getBooks() {
        return bookDao.getBooks();
    }

    @Override
    public List<Book> getBooksByType(Integer id) {
        return bookDao.getBooksByType(id);
    }

    @Override
    public Msg editBook(Map<String, String> params) {
        int bookId= Integer.parseInt(params.get("key"));
        Book book=bookDao.findOne(bookId);

        List<Type> type=typeDao.findByName(params.get("type"));
        if(type.size()==0)
        {
            return MsgUtil.makeMsg(0,"修改失败：该类别不存在，请现在TYPE-MANAGE中添加类别");
        }
       if(bookDao.editBook(params,type.get(0))==1)
       {
           return MsgUtil.makeMsg(1,"修改成功");
       }
       else return MsgUtil.makeMsg(0,"修改失败");
//        book.setInventory(Integer.parseInt(params.get("stock")));
//        book.setAuthor(params.get("author"));
//        book.setName(params.get("book"));
//        book.setDescription(params.get("description"));
//        book.setIsbn(params.get("isbn"));
//        book.setType(type.get(0));
//        book.setPrice(Double.parseDouble(params.get("price")));
//        bookRepository.saveAndFlush(book);
//
//
//        return bookDao.editBook(params);
    }

    @Override
    public Msg deleteBook(Integer id) {

      if(bookDao.findOne(id)==null)
      {
          return MsgUtil.makeMsg(0,"删除失败：不存在该数据");
      }

        //如果有外键引用
        if(orderItemDao.findOrderItemByBook(bookDao.findOne(id)).size()>0)
        {
            return MsgUtil.makeMsg(0,"删除失败：有外键引用无法删除");
        }
        bookDao.deleteById(id);
        return MsgUtil.makeMsg(1,"删除成功");
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public Book addBook(Map<String, String> params) {
        List<Type> types=typeDao.findByName(params.get("type"));
        return bookDao.addBook(params,types.get(0));
    }
}
