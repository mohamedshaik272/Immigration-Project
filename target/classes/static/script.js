document.getElementById('immigrationForm').addEventListener('submit', function(event) {
    event.preventDefault();
    alert('Form Submitted!'); // Placeholder for form submission logic
});

function addDependent() {
    const section = document.getElementById('dependentsSection');
    const newField = document.createElement('div');
    newField.innerHTML = `
        <label>Dependent's Name:</label>
        <input type="text" name="dependentName">

        <label>Relation:</label>
        <input type="text" name="dependentRelation">
    `;
    section.appendChild(newField);
}
