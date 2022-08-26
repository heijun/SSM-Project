package book.manager2.mapper;

import book.manager2.entity.AuthUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    AuthUser getPasswordByUsername(String username);

/*    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @Insert("insert into user(name, role, password) values(#{username}, #{role}, #{password})")
    int registerUser(AuthUser user);

    @Insert("insert into student(uid, name, grade, sex) values(#{uid}, #{name}, #{grade}, #{sex})")
    int addStudentInfo(@Param("uid") int uid,@Param("name") String name,@Param("grade") String grade,@Param("sex") String sex);*/


}
