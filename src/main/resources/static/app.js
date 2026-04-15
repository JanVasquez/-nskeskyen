let wishes = JSON.parse(localStorage.getItem("wishes")) || [];

function addWish() {
    const wish = {
        title: document.getElementById("title").value,
        price: document.getElementById("price").value,
        link: document.getElementById("link").value,
        priority: document.getElementById("priority").value,
        reserved: false
    };

    wishes.push(wish);
    save();
}

function toggleReserved(index) {
    wishes[index].reserved = !wishes[index].reserved;
    save();
}

function deleteWish(index) {
    wishes.splice(index, 1);
    save();
}

function save() {
    localStorage.setItem("wishes", JSON.stringify(wishes));
    render();
}