function getQueryParam(param) {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    return urlParams.get(param);
}

function loadLanguageFile(lang) {
    const pageName = document.title;
    fetch('lang/' + lang + '.json')
        .then(response => response.json())
        .then(data => {
            for (const key in data[pageName]) {
                const value = data[pageName][key];
                console.log(value);
                const element = document.querySelector('#lang-' + key);
                if (element) {
                    element.textContent = value;
                }
            }
        })
        .catch(error => {
            console.error('Error loading the language file:', error);
        });
}

const langParam = getQueryParam('lang');
if (langParam) {
    loadLanguageFile(langParam);
}