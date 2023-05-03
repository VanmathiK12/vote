package com.kgisl.vote;

public class Polling {
    protected String voter_id;
    protected String party_name;
    protected String ward;
    protected String election_date;
    protected String election_name;

    public Polling(String voter_id, String party_name, String ward) {
        this.voter_id = voter_id;
        this.party_name = party_name;
        this.ward = ward;
    }

    

    public Polling(String voter_id, String party_name, String ward, String election_date, String election_name) {
        this.voter_id = voter_id;
        this.party_name = party_name;
        this.ward = ward;
        this.election_date = election_date;
        this.election_name = election_name;
    }



    public String getElection_date() {
        return election_date;
    }



    public void setElection_date(String election_date) {
        this.election_date = election_date;
    }



    public String getElection_name() {
        return election_name;
    }



    public void setElection_name(String election_name) {
        this.election_name = election_name;
    }



    public String getVoter_id() {
        return voter_id;
    }
    public void setVoter_id(String voter_id) {
        this.voter_id = voter_id;
    }
    public String getParty_name() {
        return party_name;
    }
    public void setParty_name(String party_name) {
        this.party_name = party_name;
    }
    public String getWard() {
        return ward;
    }
    public void setWard(String ward) {
        this.ward = ward;
    }



    @Override
    public String toString() {
        return "Polling [voter_id=" + voter_id + ", party_name=" + party_name + ", ward=" + ward + ", election_date="
                + election_date + ", election_name=" + election_name + "]";
    }
    
}