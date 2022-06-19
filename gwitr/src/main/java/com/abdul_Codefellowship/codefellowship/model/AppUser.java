package com.abdul_Codefellowship.codefellowship.model;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class AppUser implements UserDetails {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @Column (unique = true)

    String username;
    String password;
    String firstName;
    String lastName;
    String dateOfBirth;
    String bio;





    @OneToMany(mappedBy = "postAuthor", cascade = CascadeType.REMOVE)


    List<Post> postList;

    @OneToMany (mappedBy = "post", cascade = CascadeType.REMOVE)
    public List<Reply> replyList;


    @ManyToMany(mappedBy = "followingSet")
    Set<AppUser> followerSet;


    @ManyToMany
    @JoinTable(
            name = "userName_to_following",
            joinColumns = {@JoinColumn(name="userName")},
            inverseJoinColumns = {@JoinColumn(name = "following")}
    )
    Set<AppUser> followingSet;



    public AppUser() {
    }

    public AppUser(String username, String password, String firstName, String lastName, String dateOfBirth, String bio) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public Set<AppUser> getFollowerSet() {
        return followerSet;
    }

    public void setFollowerSet(Set<AppUser> followerSet) {
        this.followerSet = followerSet;
    }

    public Set<AppUser> getFollowingSet() {
        return followingSet;
    }

    public void setFollowingSet(Set<AppUser> followingSet) {
        this.followingSet = followingSet;
    }
}
