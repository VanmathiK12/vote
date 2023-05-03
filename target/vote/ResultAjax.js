const uri = "http://localhost:9090/pollingStream";
let pollingDetails = [];
let updateIndex = 0;
function getAllVotes() {
    $.ajax({
        url: uri,
        type: "GET",
        dataType: "json",
        success: function (data) {
            console.log(data);
            _displayItems(data);
        },
        error: function (error) {
            console.log(`Error ${error}`);
        },
    });
}
function _displayItems(data) {
    pollingDetails = data.pollingList;
    for (var i = 0; i < data.pollingList.length; i++) {
        html += "<tr>";
        html += "<td>" + data.pollingList[i].ward + "</td>";
        html += "<td>" + data.pollingList[i].party_name + "</td>";
        html += "<td>" + data.pollingList[i].count + "</td>";
        html += "</tr>";
    }
    html += "</table>";
    document.getElementById("pollingDetails").innerHTML = html;
}