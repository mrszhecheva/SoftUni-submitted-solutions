function solve() {
  
  const inputTextArea = document.querySelector('#input');
  const resultDiv = document.querySelector('#output');

  let sentencesArr = inputTextArea.value.split('.').filter(x => x != '');

  while (sentencesArr.length > 3) {
    const paragraph = sentencesArr.splice(0, 3).join('.') + '.';
    resultDiv.innerHTML += `<p>${paragraph}</p>`;
    }
    const shorterParagraph = sentencesArr.join('.') + '.';
    resultDiv.innerHTML += `<p>${shorterParagraph}</p>`;
}