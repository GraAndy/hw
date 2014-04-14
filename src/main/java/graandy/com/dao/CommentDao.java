package graandy.com.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentDao implements ICommentDao {
	@Autowired
	SessionFactory sf;
	
	
}
