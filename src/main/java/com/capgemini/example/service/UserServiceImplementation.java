package com.capgemini.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.example.dto.UserDto;
import com.capgemini.example.entity.Address;
import com.capgemini.example.entity.User;
import com.capgemini.example.exception.AlreadyExistsException;
import com.capgemini.example.exception.IdNotFoundException;
import com.capgemini.example.exception.InvalidEmailException;
import com.capgemini.example.exception.InvalidNameException;
import com.capgemini.example.exception.InvalidPasswordException;
import com.capgemini.example.repository.AddressRepository;
import com.capgemini.example.repository.BookingRepository;
import com.capgemini.example.repository.UserRepository;
@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	BookingRepository bookingRepository;
	
	
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	
	public User userRegistration(User user)
			throws AlreadyExistsException, InvalidNameException, InvalidPasswordException, InvalidEmailException {
User local=this.userRepository.findByEmail(user.getEmail());
		
		if(local!=null)
		{
			throw new AlreadyExistsException("User already present");
		}
		else {
			if( !user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) 
			{
				throw new InvalidEmailException("INVALID_EMAIL");
			}
			if(!user.getPassword().matches("^[a-zA-Z0-9_@#]{8,14}$")) 
			{
				throw new InvalidPasswordException("INVALID_PASSWORD");
			}
			
			if(!user.getFirstName().matches("^[a-zA-Z]+(\s[a-zA-Z]+)?$") || !user.getLastName().matches("^[a-zA-Z]+(\s[a-zA-Z]+)?$"))
			{
				
				throw new InvalidNameException("INVALID_NAME_INFO");
				
			}	
		}
		return userRepository.save(user);
	}

	
    public String userLogin(String email, String password) throws InvalidEmailException, InvalidPasswordException {
        User user = userRepository.findByEmail(email);
       // System.out.println(user);
        if (user != null && user.getPassword().equals(password)) {
            return "Login Successfulyy";
        } else if(user== null) {
        	throw new InvalidEmailException("INVALID_EMAIL");
        }else{
            throw new InvalidPasswordException("INVALID_PASSWORD");
        }
    }
	
	
	
	
	
	
	
	
	public User updateUserById(int userId, User user) throws IdNotFoundException {
		User updateUser=null;
		Address updateAddress=null;
		
			if(userRepository.existsById(userId))
			{
				updateUser=userRepository.findById(userId).get();
				user.setUserId(userId);
				if(addressRepository.existsById(userId))
				{
					updateAddress=addressRepository.findById(userId).get();
					 user.getAddress().setAddressId(updateAddress.getAddressId());
					
					
				}
				
				return userRepository.save(user);
			}
			else
			{
				throw new IdNotFoundException("USER_ID_NOT_FOUND_INFO");
			}
		
	}
	
	public String deleteUserById(int userId) throws IdNotFoundException{
		String msg;
		if(userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
			msg="user deleted successfully";
		}
		else {
			throw new IdNotFoundException("USER_ID_NOT_FOUND_INFO");
		}
		return msg;
	}

	public String forgotUserPassword(UserDto userDto) throws InvalidPasswordException, InvalidEmailException {
		User user = userRepository.findByEmail(userDto.getEmail());
		if(user == null) {
			throw new InvalidEmailException("USER_INVALID_EMAIL_INFO");
		}else if(!userDto.getPassword().matches("^[a-zA-Z0-9_@#]{8,14}$") || !userDto.getConfirmPassword().matches("^[a-zA-Z0-9_@#]{8,14}$"))
			throw new InvalidPasswordException("INVALID_PASSWORD_INFO");
		else if(!userDto.getPassword().equals(userDto.getConfirmPassword()))
			throw new InvalidPasswordException("PASSWORD_MISMATCH_INFO");
		else{
			user.setPassword(userDto.getPassword());
			userRepository.save(user);
			return "Password Reset Successful";
		}
	}

	
	
	public String resetUserPassword(int userId, UserDto userDto) throws IdNotFoundException, InvalidPasswordException {
		User user = userRepository.findById(userId).get();
		if(user == null) {
			throw new IdNotFoundException("USER ID NOT FOUND");
		}else if(!userDto.getPassword().matches("^[a-zA-Z0-9_@#]{8,14}$") || !userDto.getConfirmPassword().matches("^[a-zA-Z0-9_@#]{8,14}$"))
			throw new InvalidPasswordException("INVALID_PASSWORD_INFO");
		else if(!userDto.getPassword().equals(userDto.getConfirmPassword()))
			throw new InvalidPasswordException("PASSWORD_MISMATCH_INFO");
		else{
			user.setPassword(userDto.getPassword());
			userRepository.save(user);
			return "Password Reset Successful";
		}
	}
	public UserDto getUserDashboard(int userId) throws IdNotFoundException {
		if(userRepository.existsById(userId)) {
		User user =userRepository.findByUserId(userId);
		UserDto newUser=new UserDto();
		newUser.setUserId(user.getUserId());
		newUser.setUserName(user.getUserName());
		newUser.setEmail(user.getEmail());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setMobileNo(user.getMobileNo());
		return newUser;
		}else {
			throw new IdNotFoundException("User id is not found");
		}
	}


	@Override
	public User getUserById(int userId) throws IdNotFoundException {
		User user=userRepository.findByUserId(userId);
		return user;
		
	}
	
}
