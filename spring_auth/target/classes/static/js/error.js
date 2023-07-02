$(window).on("error", function(evt) {

    console.log("jQuery error event:", evt);
    var e = evt.originalEvent; // get the javascript event
    console.log("original event:", e);
    if (e.message) {
        alert(e.message);
    } else {
        alert("Error:\n\t" + e.type + "\nElement:\n\t" + (e.srcElement || e.target));
    }
});

