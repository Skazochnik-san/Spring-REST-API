<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
<div>
    <@l.logout />
</div>

<div>Добавить сообщение</div>
<form method="post" action="/main">
    <input type="text" name="text" placeholder="Введите сообщение" />
    <input type="text" name="tag" placeholder="Введите tag" />
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">Добавить</button>
</form>

<form method="get" action="/main">
    <input type="text" name="filter" value="${filter!}">
    <button type="submit">Найти</button>
</form>

<div>Список сообщений</div>

<#list messagesList as message>
    <div>
        <b>${message.id}</b>
        <span>${message.text}</span>
        <i>${message.tag}</i>
        <strong>${message.authorName}</strong>
    </div>
<#else>
No message
</#list>
</@c.page>