package designpatterns.structrual.decorator;

public class DecoratorRunner {
    public static void main(String... args){

        TextContent textContent = new TextContent("Hello world!");
        TextDecorator textDecorator = new ParaDecorator(textContent);
        textDecorator.decorate();

        textDecorator = new DivDecorator(textContent);
        textDecorator.decorate();
        System.out.println(textContent.getContent());
    }

}

class TextContent{
    private String content;

    public TextContent(String text){
        this.content = text;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

interface TextDecorator{
    public void decorate();
}

class ParaDecorator implements TextDecorator{
    private TextContent textContent;

    public ParaDecorator(TextContent textContent) {
        this.textContent = textContent;
    }

    @Override
    public void decorate(){
        this.textContent.setContent("<p>" + this.textContent.getContent() + "<p>");
    }
}


class DivDecorator implements TextDecorator{
    private TextContent textContent;

    public DivDecorator(TextContent textContent) {
        this.textContent = textContent;
    }

    @Override
    public void decorate(){
        this.textContent.setContent("<div>" + this.textContent.getContent() + "</div>");
    }
}
