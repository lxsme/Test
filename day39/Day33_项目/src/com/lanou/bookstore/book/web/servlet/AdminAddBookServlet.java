package com.lanou.bookstore.book.web.servlet;

import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.domain.Book;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@MultipartConfig
@WebServlet(name = "AdminAddBookServlet",urlPatterns = "/aab")
public class AdminAddBookServlet extends HttpServlet {
    private static Logger LOGGER = Logger.getLogger (String.valueOf(AdminAddBookServlet.class));
    BookDao bookDao = new BookDao();
    private String path;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
//        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        File repository = (File) servletContext.getAttribute("C:\\Users\\lanou\\Desktop\\JavaSE");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(repository);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);


        // Parse the request
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(req);

        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        // Process the uploaded items
        Iterator<FileItem> iter = items.iterator();
        Map<String, Object> map = new HashMap<>();
        while (iter.hasNext()) {
            FileItem item = iter.next();
            if (item.isFormField()) {
                String name = item.getFieldName();
                String value = item.getString();
                map.put(name, value);
                try {
                    int bid = bookDao.maxCid()+2;
                    map.put("bid",bid);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                String fieldName = item.getFieldName();
                String fileName = item.getName();
                String contentType = item.getContentType();
                boolean isInMemory = item.isInMemory();
                long sizeInBytes = item.getSize();
                path = "C:/Users/lanou/Desktop/pic/"+fileName;
                map.put("image", path);
//                System.out.println("fieldName----"+fieldName);
//                System.out.println("fileName-----"+fileName);
//                System.out.println("contentType---"+contentType);
//                System.out.println("isInMemory----"+isInMemory);
//                System.out.println("sizeInBytes---"+sizeInBytes);


            }
//            InputStream picSteam = getServletContext().getResourceAsStream(path);
//            byte[] bytes = IOUtils.toByteArray(picSteam);
//            resp.getOutputStream().write(bytes);

        }

//        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String, Object> next = iterator.next();
//            System.out.println("key---"+next.getKey()+"---value---"+next.getValue());
            Book book = new Book();
        try {
            BeanUtils.populate(book,map);

            bookDao.insert(book);
           resp.sendRedirect("/adminjsps/admin/book/list.jsp");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }




    private void processUploadedFile(FileItem item) {
    }

    private void processFormField(FileItem item) {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // 判断enctype属性是否为multipart/form-data
//        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

//        Create a factory for disk-based file items
//        DiskFileItemFactory factory = new DiskFileItemFactory();

//        当上传文件太大时，因为虚拟机能使用的内存是有限的，所以此时要通过临时文件来实现上传文件的保存
//        此方法是设置是否使用临时文件的临界值（单位：字节）
//        factory.setSizeThreshold(1024*1024);
//
//// 与上一个结合使用，设置临时文件的路径（绝对路径）
//        factory.setRepository(new File("C:\\Users\\lanou\\Desktop\\JavaSE"));
//
//// Create a new file upload handler
//        ServletFileUpload upload = new ServletFileUpload(factory);
//
//// 设置上传内容的大小限制（单位：字节）
//        upload.setSizeMax(1024*1024);
//
//// Parse the request
//        List<?> items = null;
//        try {
//            items = upload.parseRequest(request);
//        } catch (FileUploadException e) {
//            System.out.println("1111111");
//            e.printStackTrace();
//        }
//
//        Iterator iter = items.iterator();
//        while (iter.hasNext()) {
//            FileItem item = (FileItem) iter.next();
//
//            if (item.isFormField()) {
//                //如果是普通表单字段
//                String name = item.getFieldName();
//                String value = item.getString();
//
//
//                System.out.println(name);
//                System.out.println(value);

//
//
//
//            } else {
//                //如果是文件字段
//                String fieldName = item.getFieldName();
//                String fileName = item.getName();
//                String contentType = item.getContentType();
//                boolean isInMemory = item.isInMemory();
//                long sizeInBytes = item.getSize();


//                // Process a file upload
//                if (writeToFile) {
//                    File uploadedFile = new File(...);
//                    item.write(uploadedFile);
//                } else {
//                    InputStream uploadedStream = item.getInputStream();
//                    byte[] a = new byte[1024*1024];
//
//                    int read = 0;
//                    if ((read = uploadedStream.read(a)) !=-1){
//
//                    }
//
//                    uploadedStream.close();
//                }
//            }
//        }





    }
}
