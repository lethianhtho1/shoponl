package com.web.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.web.dao.ProductDAO;
import com.web.entities.Item;
import com.web.entities.Product;

public class CartService {
	private static HashMap<Integer ,Item> cart ; 
	private static CartService cartService;
     
		 public static CartService getInstance() 
		 {
			if(cart==null)
			{
				cart = new HashMap<>();
			}
			if(cartService==null)
			{
				cartService= new CartService();
			}
			return cartService;
		 }
		 
	    private CartService() {
	    	
	    }
	    
	    
	    public CartService(HashMap<Integer, Item> cart) {
	        this.cart = cart;
	    }
	    public HashMap<Integer, Item> getList() {
	        return cart;
	    }
	    public void setList(HashMap<Integer, Item> cart) {
	        this.cart = cart;
	    }
	     
	    public void addList(Integer id)
	    {
	        if(cart.containsKey(id))
	        {  

              Item item= cart.get(id);
	             
              int count = item.getNumber();
		     count = count + 1;
	             item.setNumber(count);
	        }
	        else {  

	          Product product= ProductDAO.getInstance().getProductById(id);
	          Item item = new Item(product,1);
	          cart.put(id, item);
	        }
	    }
	    
	    public void removeProduct(Integer id)
	    {
	    	cart.remove(id);
	    }
	    
	    public void removeAll()
	    {
	    	cart.clear();
	    }
	    
	    public int totalList()
	    {
	        int total=0;
	        for(Item item : cart.values())
	        {
	            total = total + (item.getProduct().getPrice() * item.getNumber());
	        }
	        return total;
	    }
	    
	    public ArrayList<Item> getListItems()
	    {
	    	ArrayList<Item> listItems = new ArrayList<>();
	        for(Item i : cart.values())
	        {
	            listItems.add(i);
	        }
	        return listItems;
	    }

}
