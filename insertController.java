package myprojectdemo.web.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import myprojectdemo.web.model.childModel;
import myprojectdemo.web.model.countryModel;
import myprojectdemo.web.model.userModel;
import myprojectdemo.web.model.dao.genericDao;

@Controller
public class insertController {

	@Autowired
	genericDao d;
	@Autowired
	ServletContext sc;
	
	public File getDirectory()
	{/*
		System.out.println("path=="+sc.getRealPath("/upload/"));
		return new File(sc.getRealPath("/upload/"));*/
		
		System.out.println("path=="+sc.getRealPath("/upload/"));
		return new File(sc.getRealPath("/upload/"));
	}
	
	@RequestMapping(value="Chaudhari.Rahul", method = RequestMethod.GET)
	public String userIndex(ModelMap m)
	{
		m.put("list",d.display(new countryModel()));
		m.put("usrmodel", new userModel());
		
		return "home";
		
	}
	
	@RequestMapping(value="Country.Rahul", method = RequestMethod.GET)
	public String Country(ModelMap m)
	{
		m.put("usrmodel", new countryModel());
		
		return "country";
		
	}
	
	@RequestMapping(value="Country.Rahul", method = RequestMethod.POST)
	public String Country(@ModelAttribute("usrmodel") countryModel m, BindingResult result)
	{
		d.insert(m);
		
		return "country";
		
	}
	
	@RequestMapping(value="download.Rahul",method=RequestMethod.GET)
    public void downloadPDFResource( HttpServletRequest request,
                                     HttpServletResponse response,
                                     @RequestParam("fi") String fileName)
    {
        //If user is not authorized - he should be thrown out from here itself
         
        //Authorized user will download the file
        Path file = Paths.get(sc.getRealPath("/upload/"), fileName);
        if (Files.exists(file))
        {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
	
	@RequestMapping(value="Chaudhari.Rahul", method = RequestMethod.POST)
	public String userIndex(@ModelAttribute("usrmodel") userModel m, @RequestParam("fileupld") MultipartFile a,HttpServletRequest request ,@RequestParam("fname") String[] fname,@RequestParam("addr") String[] addr, BindingResult result)
	{
		try
		{
			if(a != null)
			{
				a.transferTo(new File(getDirectory(),a.getOriginalFilename()));
				m.setFilename(a.getOriginalFilename());
		
				d.insert(m);
				
				
				//Addrow hibernate(one to many relationship
				for (int i = 0; i < fname.length; i++) {
					
					String ge = request.getParameter("gender"+(i+1));
					
					childModel cc = new childModel(fname[i], addr[i], ge, m);
					d.insert(cc);
				}//finish
				
				System.out.println("Name:"+m.getName());
			}
		}
		catch(IOException e	)
		{
			System.out.println(e);
			return "home";
		}
		return "home";
		
	}
	
	
	
	@RequestMapping(value="displaydata.Rahul", method = RequestMethod.GET)
	public String user(ModelMap m)
	{
		m.put("list", d.display(new userModel()));
		return "Display";
		
	}
	
	@RequestMapping(value="delete.Rahul", method = RequestMethod.GET)
	public String delete(ModelMap m,@RequestParam("id") int id)
	{
		long h = d.dele("childModel", "mas_id", id);
		System.out.println("ss");
		userModel u = new userModel(id);
		d.delete(u);
		
		
		return "redirect:displaydata.Rahul";
		
	}
	
	@RequestMapping(value="update.Rahul", method = RequestMethod.GET)
	public String update(ModelMap m,@RequestParam("id") int id)
	{
		
		m.put("list",d.display(new countryModel()));
		userModel h = d.get(id,new userModel());	
		m.put("usrmodel",h);
		
		return "update";

	}
	
	@RequestMapping(value="update.Rahul", method = RequestMethod.POST)
	public String userupdate(@ModelAttribute("usrmodel") userModel m, @RequestParam("fileupld") MultipartFile a,HttpServletRequest request ,@RequestParam("fname") String[] fname,@RequestParam("addr") String[] addr, BindingResult result)
	{
		try
		{
			if(a != null)
			{
				a.transferTo(new File(getDirectory(),a.getOriginalFilename()));
				m.setFilename(a.getOriginalFilename());
		
				d.insert(m);
				
				
				//Addrow hibernate(one to many relationship
				for (int i = 0; i < fname.length; i++) {
					
					String ge = request.getParameter("gender"+(i+1));
					
					childModel cc = new childModel(fname[i], addr[i], ge, m);
					d.insert(cc);
				}//finish
				
				System.out.println("Name:"+m.getName());
			}
		}
		catch(IOException e	)
		{
			System.out.println(e);
			return "home";
		}
		return "home";
		
	}
	
	@RequestMapping(value = "login.Rahul",  method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }

	
	 @RequestMapping(value = "loginError.Rahul",  method = RequestMethod.GET)
	    public String loginError()
	    {
	        return "loginError";
	    }
	   
	 @RequestMapping(value = "logout.Rahul",  method = RequestMethod.GET)
	    public String logout()
	    {
	        return "logout";
	    }
	   
 
	
} 
