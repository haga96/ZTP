package servlets;

import bean.Book;
import lombok.SneakyThrows;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;


@WebListener
public class LibraryContextServletListener implements ServletContextListener{
    @SneakyThrows
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<Book> bookList = new ArrayList<>();

         bookList.add(new Book("The Clean Code", "Robert C.", "Martin", "2008-08-15"));
         bookList.add(new Book("Animal Farm", "George", "Orwell", "1945-08-17"));
         bookList.add(new Book("Don Quixote", "Miguel", "de Cervantes", "1605-08-17"));


        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("bookList", bookList);
    }
}
