package com.sam.app.submission;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
@SpringJUnitConfig
@WebMvcTest(ApiControllers.class)
public class ApiControllersTest {
    @MockBean
    private UserRepo userRepo;
    @MockBean
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void getPage_shouldReturnListOfUsers() throws Exception {
        User user1 = new User();
        user1.setId(1L);
        user1.setConsultantName("Samanvitha");
        user1.setSubmissionDate("07/11/23");
        user1.setLeadName("Vinay");
        user1.setRate("70");
        user1.setSalesPersonName("Abc");
        user1.setTechnology("JFSD");
        user1.setImplementation("niytho infotech");
        user1.setVendorName("Nawaz");
        User user2 = new User();
        user2.setId(2L);
        user2.setConsultantName("Samanvitha");
        user2.setSubmissionDate("07/11/23");
        user2.setLeadName("Vinay");
        user2.setRate("70");
        user2.setSalesPersonName("Abc");
        user2.setTechnology("JFSD");
        user2.setImplementation("niytho infotech");
        user2.setVendorName("Nawaz");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        when(userRepo.findAll()).thenReturn(userList);
        mockMvc.perform(MockMvcRequestBuilders.get("/submissions")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ConsultantName").value("Samanvitha"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].SubmissionDate").value("07/11/23"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].LeadName").value("Vinay"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].Rate").value("70"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].SalesPersonName").value("Abc"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].Technology").value("JFSD"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].Implementation").value("nithya infotech"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].VendorName").value("Nawaz"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].consultantName").value("Samanvitha"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].SubmissionDate").value("07/11/23"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].LeadName").value("Vinay"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].Rate").value("70"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].SalesPersonName").value("Abc"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].Technology").value("JFSD"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].Implementation").value("nithya infotech"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].VendorName").value("Nawaz"));
        verify(userRepo, times(1)).findAll();
    }
    @Test
    public void getUsers_withValidId_shouldReturnUser() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setConsultantName("Samanvitha");
        user.setSubmissionDate("07/11/23");
        user.setLeadName("Vinay");
        user.setRate("70");
        user.setSalesPersonName("Abc");
        user.setTechnology("JFSD");
        user.setImplementation("niytho infotech");
        user.setVendorName("Nawaz");
        when(userRepo.findById(1L)).thenReturn(Optional.of(user));
        mockMvc.perform(MockMvcRequestBuilders.get("/submissions/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ConsultantName").value("Samanvitha"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.SubmissionDate").value("07/11/23"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.LeadName").value("Vinay"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Rate").value("70"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.SalesPersonName").value("Abc"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Technology").value("JFSD"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Implementation").value("nithya infotech"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.VendorName").value("Nawaz"));
        verify(userRepo, times(1)).findById(1L);
    }
    @Test
    public void saveUser_withValidUser_shouldReturnSavedUser() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setConsultantName("Samanvitha");
        user.setSubmissionDate("07/11/23");
        user.setLeadName("Vinay");
        user.setRate("70");
        user.setSalesPersonName("Abc");
        user.setTechnology("JFSD");
        user.setImplementation("niytho infotech");
        user.setVendorName("Nawaz");
        when(userService.addNewUser(any(User.class))).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.post("/submissions")
//                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1, \"consultantName\": \"Samanvitha\", \"submissionDate\": \"07/11/23\", \"leadName\": \"Vinay\", \"rate\": \"70\", \"salesPersonName\": \"Abc\", \"technology\": \"JFSD\", \"implementation\": \"nithya infotech\", \"vendorName\": \"Nawaz\"}"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.consultantName").value("Samanvitha"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.submissionDate").value("07/11/23"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.leadName").value("Vinay"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rate").value("70"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.salesPersonName").value("Abc"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.technology").value("JFSD"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.implementation").value("nithya infotech"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.vendorName").value("Nawaz"));
        verify(userService, times(1)).addNewUser(any(User.class));
    }
    @Test
    public void updateUser_withValidIdAndUser_shouldReturnSuccessMessage() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setConsultantName("Samanvitha");
        user.setSubmissionDate("07/11/23");
        user.setLeadName("Vinay");
        user.setRate("70");
        user.setSalesPersonName("Abc");
        user.setTechnology("JFSD");
        user.setImplementation("niytho infotech");
        user.setVendorName("Nawaz");
        when(userRepo.findById(1L)).thenReturn(Optional.of(user));
        mockMvc.perform(MockMvcRequestBuilders.put("/submissions/update/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"consultantName\": \"Updated Name\"}"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Update Success..."));
        verify(userRepo, times(1)).findById(1L);
        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepo, times(1)).save(argumentCaptor.capture());
        User updatedUser = argumentCaptor.getValue();
    }

    @Test
    public void deleteUser_withValidId_shouldReturnSuccessMessage() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setConsultantName("Samanvitha");
        user.setSubmissionDate("07/11/23");
        user.setLeadName("Vinay");
        user.setRate("70");
        user.setSalesPersonName("Abc");
        user.setTechnology("JFSD");
        user.setImplementation("niytho infotech");
        user.setVendorName("Nawaz");
        when(userRepo.findById(1L)).thenReturn(Optional.of(user));
        mockMvc.perform(MockMvcRequestBuilders.delete("/submissions/{id}", 1L))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Deleted the user with id:1"));
        verify(userRepo, times(1)).findById(1L);
        verify(userRepo, times(1)).delete(user);
    }
}
