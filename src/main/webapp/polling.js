const uri = "http://localhost:9090/polling";
function addItem() {
    console.log("polling add item");
    const voter_id = document.getElementById("voter_id").value;
    const election_name = document.getElementById("election_name").value;

    // check if the same voter has already voted in the same election
    if (localStorage.getItem(voter_id) === election_name) {
        alert("You have already voted in this election.");
        window.location.replace("http://localhost:9090/index.jsp");
        return;
    }

    const item = {
        voter_id: voter_id,
        ward: document.getElementById("ward").value,
        party_name: document.getElementById("party_name").value,
        election_name: election_name,
        election_date: document.getElementById("election_date").value,
    };
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", uri, true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            // save the voter's vote for this election in local storage
            localStorage.setItem(voter_id, election_name);
            window.location.replace("http://localhost:9090/index.jsp");
        }
    }
    xhttp.send(JSON.stringify(item));
    console.log(item);

    alert("Your vote is submitted successfully.");
}
function updateDate() {
        var election_name = document.getElementById("election_name").value;
        var date;
        switch (election_name) {
            case "MLA":
                date = "12/5/2023";
                break;
            case "MP":
                date = "25/8/2023";
                break;
        }
        document.getElementById("election_date").value = date;
    }

