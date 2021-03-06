//@ sourceURL=src/test/resources/templates/layout-markup.html.js

function render(lorem, fruit) {
    'use strict';

    // Modify the fruit list
    $('ul').empty();
    fruit = Java.from(fruit);
    fruit.forEach(function (type) {
        $('ul').append('<li>' + type + '</li>');
    });

    // Replace all of the meat with filler.
    $('p').html(lorem);

    return { layout: "templates/layout.html" };
}
