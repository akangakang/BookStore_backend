package com.example.bookback.serviceimpl;

import com.example.bookback.dao.BookDao;
import com.example.bookback.dao.TypeDao;
import com.example.bookback.entity.Type;
import com.example.bookback.service.TypeService;
import com.example.bookback.utils.msgutils.Msg;
import com.example.bookback.utils.msgutils.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeDao typeDao;

    @Autowired
    BookDao bookDao;
    @Override
    public List<Type> findAll() {
        return typeDao.findAll();
    }

    @Override
    public Msg editType(Map<String, String> params) {
        return typeDao.editType(params);
    }

    @Override
    public Msg deleteType(Integer id) {
        if(typeDao.findById(id)==null)
        {
            return MsgUtil.makeMsg(0,"删除失败：不存在该数据");
        }
        if(bookDao.findByType(id).size()>0)
        {
            return MsgUtil.makeMsg(0,"删除失败：有外键引用无法删除");
        }
        typeDao.deleteById(id);
        return MsgUtil.makeMsg(1,"删除成功");
       // return typeDao.deleteType(id);
    }

    @Override
    public Type addType(Map<String, String> params) {
        return typeDao.addType(params);
    }
}
