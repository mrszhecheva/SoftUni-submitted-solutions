function solve() {
    document.querySelector('#searchBtn').addEventListener('click', onClick);
    
    const body = document.querySelectorAll('tbody');
    
    function onClick() {
        const input = document.querySelector('#searchField').value.toLowerCase();
       
        body.innerHTML = Array.from(body.children).map(function selectRow (row) {
            if ((row.textContent).toLowerCase().includes(input)) {  
                row.setAttribute('class', 'select');
            } else {
                row.removeAttribute('class');
            }
            return row;
        });
    }
}