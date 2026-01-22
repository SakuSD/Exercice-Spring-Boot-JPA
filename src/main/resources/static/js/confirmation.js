document.addEventListener('DOMContentLoaded', () => {
    const deleteButtons = document.querySelectorAll('.btn-delete');
    deleteButtons.forEach(btn => {
        btn.addEventListener('click', function(event) {
            const nom = this.getAttribute('data-nom');
            if(!confirm(`Voulez-vous vraiment supprimer le thé "${nom}" ?`)) {
                event.preventDefault();
            }
        });
    });
});
