package web;

import classes.Jobs;
import classes.NormalUser;
import classes.app_service;
import classes.user_service;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Created by IBM on 23/03/2017.
 */
public class Uploadfile extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;

    private int userId;
    private RequestDispatcher view;

    private user_service us= new user_service();
    private app_service app_s=new app_service();
    private int userType;
    private String gerror;

    @Override

    public void init() throws ServletException{

        DiskFileItemFactory fileFactory = new DiskFileItemFactory();
        File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
        fileFactory.setRepository(filesDir);
        this.uploader = new ServletFileUpload(fileFactory);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null) {
            // Not created yet. Now do so yourself.

            view= request.getRequestDispatcher("Login.jsp"); //if no user get to
            view.forward(request,response);


        } else {

            String fileName = request.getParameter("fileName");

            if(fileName == null || fileName.equals("")){
                gerror="No such file exist !!!!";
                request.setAttribute("gerror",gerror);
                view= request.getRequestDispatcher("error.jsp");
                view.forward(request,response);


            }

            File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileName);

            if(!file.exists()){
                gerror="No such file exist !!!!";
                request.setAttribute("gerror",gerror);
                view= request.getRequestDispatcher("error.jsp");
                view.forward(request,response);

                throw new ServletException("File doesn't exists on server.");

            }

            System.out.println("File location on server::"+file.getAbsolutePath());

            ServletContext ctx = getServletContext();

            InputStream fis = new FileInputStream(file);

            String mimeType = ctx.getMimeType(file.getAbsolutePath());

            response.setContentType(mimeType != null? mimeType:"application/octet-stream");

            response.setContentLength((int) file.length());

            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");



            ServletOutputStream os= response.getOutputStream();

            byte[] bufferData = new byte[1024];

            int read=0;

            while((read = fis.read(bufferData))!= -1){

                os.write(bufferData, 0, read);

            }

            os.flush();

            os.close();

            fis.close();

            System.out.println("File downloaded at client successfully");

        }



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null) {
            // Not created yet. Now do so yourself.

            view= request.getRequestDispatcher("Login.jsp"); //if no user get to
            view.forward(request,response);


        } else {
            // Already created.

            userId = (int) session.getAttribute("uId");
            userType = (int) session.getAttribute("uType");

            if(!ServletFileUpload.isMultipartContent(request)){

                throw new ServletException("Content type is not multipart/form-data");

            }



            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

            out.write("<html><head></head><body>");

            try {

                List<FileItem> fileItemsList = uploader.parseRequest(request);

                Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();

                while(fileItemsIterator.hasNext()){

                    FileItem fileItem = fileItemsIterator.next();
                    String name=fileItem.getName();

                    String[] parts = name.split("\\.");
                    name=userId+"."+parts[1];
                    if(parts[1].equals("pdf")){
                        //only pdf file allowed
                        System.out.println("FieldName="+fileItem.getFieldName());

                        System.out.println("FileName="+fileItem.getName());

                        System.out.println("ContentType="+fileItem.getContentType());

                        System.out.println("Size in bytes="+fileItem.getSize());
                        File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+name);

                        System.out.println("Absolute Path at server="+file.getAbsolutePath());

                        fileItem.write(file);

                        String cvlink=name;
                        us.insertcv(userId,cvlink); //cvuploaded in the server

                        ArrayList<Jobs> JobsCanApply=new ArrayList<Jobs>();
                        NormalUser normalUser= new NormalUser();
                        normalUser=us.getnormaluserbyid(userId);
                        try {
                            //getting the list of the job that are yet to be applied
                            JobsCanApply= app_s.get_app_joblist(userId);
                            //setting up the Job List under the request dispatcher
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        //seetting up request dispatcher
                        request.setAttribute("joblist",JobsCanApply);
                        request.setAttribute("normaluser",normalUser);

                        view= request.getRequestDispatcher("DashBoardMain_Applicant.jsp");
                        view.forward(request,response);

                    }else {
                        String msg= "Incorrect format, please try again";
                        request.setAttribute("incorrect",msg);
                        view= request.getRequestDispatcher("test.jsp");
                        view.forward(request,response);
                    }



                }

            } catch (FileUploadException e) {

                gerror="Hello, watch out for the file you are trying to upload. ";
                request.setAttribute("gerror",gerror);
                view= request.getRequestDispatcher("error.jsp");
                view.forward(request,response);

                out.write(String.valueOf(e.getStackTrace()));

            } catch (Exception e) {

                e.printStackTrace();

            }

        }
        }






}
