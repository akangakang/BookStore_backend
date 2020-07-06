package com.example.bookback.daoimpl;

import com.example.bookback.dao.TypeDao;
import com.example.bookback.entity.Type;
import com.example.bookback.repository.BookRepository;
import com.example.bookback.repository.TypeRepository;
import com.example.bookback.utils.msgutils.Msg;
import com.example.bookback.utils.msgutils.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TypeDaoImpl implements TypeDao {
    @Autowired
    TypeRepository typeRepository;

    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Msg editType(Map<String, String> params) {
        int typeId=Integer.parseInt(params.get("typeid"));
        Type type=typeRepository.findById(typeId).get();

        if(typeRepository.findByName(params.get("name")).size()>1)
        {
            return MsgUtil.makeMsg(0,"修改失败：类型名重复");
        }

        type.setDescription(params.get("description"));
        type.setName(params.get("name"));
        typeRepository.saveAndFlush(type);
        return MsgUtil.makeMsg(1,"修改成功");
    }

    @Override
    public Type findById(Integer id) {
        if (!typeRepository.findById(id).isPresent())
            return null;
        else return typeRepository.findById(id).get();

    }

//    @Override
//    public Msg deleteType(Integer id) {
//        if(!typeRepository.findById(id).isPresent())
//        {
//            return MsgUtil.makeMsg(0,"删除失败：不存在该数据");
//        }
//        if(bookRepository.findByType(id).size()>0)
//        {
//            return MsgUtil.makeMsg(0,"删除失败：有外键引用无法删除");
//        }
//        typeRepository.deleteById(id);
//        return MsgUtil.makeMsg(1,"删除成功");
//    }

    @Override
    public Type addType(Map<String, String> params) {
        Type type=new Type();
        type.setName(params.get("name")+type.getTypeid());
        type.setDescription(params.get("description"));
        typeRepository.saveAndFlush(type);
        return type;
    }

    @Override
    public List<Type> findByName(String name) {
        return typeRepository.findByName(name);
    }

    @Override
    public void deleteById(Integer id) {
        typeRepository.deleteById(id);
    }
}
