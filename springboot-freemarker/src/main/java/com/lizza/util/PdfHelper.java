package com.lizza.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.util.FileCopyUtils;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-09-19
 */
public class PdfHelper {

    private static final String SRC_PATH = "/templates/";
    private static final String DES_PATH = "./templates/";
    private static final String FONT = "simhei.ttf";

    public static void download(HttpServletResponse response, Map<String, Object> data, String templateName) {
        Document document = new Document();
        PdfWriter writer;
        String content = render(data, templateName);
        try {
            response.reset();
            response.setHeader("Content-Disposition", "attachment;  filename=" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".pdf");
            response.setCharacterEncoding("utf-8");
            writer = PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            getResource(FONT);
            XMLWorkerFontProvider fontProvider =
                    new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
            fontProvider.register(DES_PATH + FONT);
            XMLWorkerHelper.getInstance()
                    .parseXHtml(writer, document, new ByteArrayInputStream(content.getBytes()), null,
                            Charset.forName("UTF-8"), fontProvider);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    public static String render(Map<String, Object> data, String templateName) {
        Writer out = new StringWriter();
        try {
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
            getResource(templateName);
            configuration.setDirectoryForTemplateLoading(new File(DES_PATH));
            Template template = configuration.getTemplate(templateName);
            data.put("msg", "Lizza, 你好呀!");
            template.process(data, out);
            out.flush();
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    private static void getResource(String resourceName) throws IOException {
        InputStream is = PdfHelper.class.getResourceAsStream(SRC_PATH + resourceName);
        File target = new File(DES_PATH + resourceName);
        if (!target.exists()) {
            target.getParentFile().mkdirs();
            FileCopyUtils.copy(is, new FileOutputStream(target));
        }
    }
}
