function deleteConfirm(id) {
    var result = confirm("この操作は後から取り消せません。よろしいでしょうか？");
    if (result) {
        // IDをPOSTリクエストとして送信する
        fetch('/delete', {
            method: 'POST',
            headers: {
                'Content-Type': 'text/plain',
            },
            body: id.toString()
        })
        .then(response => {
            if (response.ok) {
                //  正常にdelete出来ていた場合
                window.location.href = '/';
            } else {
                //  失敗した場合
                throw new Error('サーバーに問題が発生しました。');
            }
        })
        .catch(error => {
            console.error('削除失敗:', error);
        });
    }
    else {
        alert("操作をキャンセルしました");
    }
}