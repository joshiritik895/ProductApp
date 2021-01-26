package productapp.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import productapp.dao.ProductDao;
import productapp.model.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productdao;

	@RequestMapping("/")
	public String home(Model m) {
		List<Product> productlist = productdao.getProducts();
		m.addAttribute("products", productlist);
		return "index";
	}
	
	
	//show add product form 
	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add Product");
		return "add_product_form"; 
	}
	
	//handle add product form 
	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute  Product product,@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request, HttpSession session) {
		System.out.println(product);
		ServletContext context = session.getServletContext();
		String rootPath = context.getRealPath("/");
		String filename=file.getOriginalFilename();  
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				File dir = new File(rootPath + File.separator + "Fileupload");
				if (!dir.exists())
					dir.mkdirs();
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + filename);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		productdao.createProduct(product);
		RedirectView redirectview =  new RedirectView();
		redirectview.setUrl(request.getContextPath()+"/");
		return redirectview;
		
	}
	//delete item
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteproduct(@PathVariable("productId") int productId, HttpServletRequest request) {
		productdao.deleteProduct(productId);
		RedirectView redirectview =  new RedirectView();
		redirectview.setUrl(request.getContextPath()+"/");
		return redirectview;
	}
	//update product
	@RequestMapping("/update/{productId}")
	public String updateproduct(@PathVariable("productId") int pid, Model m) {
		Product p = productdao.getProduct(pid);
		m.addAttribute("product", p);
		return "updateproduct";
	}
	
	
}
