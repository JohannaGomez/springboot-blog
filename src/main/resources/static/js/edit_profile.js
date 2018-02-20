var fsClient = filestack.init('AhUnvEQEJTyXPRXCHgUZuz');

$(document).ready(function () {

    $('#upload-button').click(function () {
        openPicker();

    });


    // function openPicker() {
    //     fsClient.pick({
    //         fromSources:["local_file_system","imagesearch","facebook","instagram","dropbox"]
    //     }).then(function(response) {
    //         console.log(response.filesUploaded[0].url);
    //         var conImage = {
    //             url: response.filesUploaded[0].url
    //         };
    //         $.post("/profile/image", conImage).done(function(response) {
    //             localStorage.clear();
    //             window.location.reload(true);
    //             window.location = "/user/edit";
    //             console.log(response)
    //         });
    //     });
    // }

    function openPicker() {
        fsClient.pick({
            fromSources: ["local_file_system", "imagesearch", "facebook", "instagram", "webcam"],
            accept: ["image/*"],
            maxFiles: 1,
            transformations: {
                crop: {force: true}
            }
        }).then(function (response) {
            console.log(response.filesUploaded[0].url);
            $("input[name=profile_pic]").val(response.filesUploaded[0].url);
            // for html
            $("#upload-button").attr("src", response.filesUploaded[0].url);
        });
    }
});