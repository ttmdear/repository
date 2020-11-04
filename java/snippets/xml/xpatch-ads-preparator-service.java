/**
 * Przykład usługi do wyciągania danych z XMLa za pomą Xpatcha.
 */

public interface AdsPreparatorService {
    AdsPrepared prepare(Ads notice) throws Exception;
}

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import javax.xml.xpath.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@Service
public class AdsPreparatorServiceImpl implements AdsPreparatorService {
    private static final XPathExpression clientTypeExp;
    private static final XPathExpression orderTypeExp;
    private static final XPathExpression noticeTypeExp;
    private static final XPathExpression noticeNumberExp;
    private static final XPathExpression publicationDateExp;
    private static final XPathExpression submittingOffersDateExp;

    private static final XPathExpression contractorNameExp;
    private static final XPathExpression contractorCityExp;
    private static final XPathExpression contractorCountryExp;
    private static final XPathExpression organizationNameExp;
    private static final XPathExpression organizationCityExp;
    private static final XPathExpression organizationCountryExp;
    private static final XPathExpression cpvCodeExp;

    static {
        XPath xPath = XPathFactory.newInstance().newXPath();

        try {
            // @formatter:off
            clientTypeExp = xPath.compile("/TED_EXPORT/CODED_DATA_SECTION/CODIF_DATA/AA_AUTHORITY_TYPE/@CODE");
            orderTypeExp = xPath.compile("/TED_EXPORT/CODED_DATA_SECTION/CODIF_DATA/NC_CONTRACT_NATURE/@CODE");
            noticeTypeExp = xPath.compile("/TED_EXPORT/CODED_DATA_SECTION/CODIF_DATA/TD_DOCUMENT_TYPE/@CODE");
            noticeNumberExp = xPath.compile("/TED_EXPORT/CODED_DATA_SECTION/NOTICE_DATA/NO_DOC_OJS");
            publicationDateExp = xPath.compile("/TED_EXPORT/CODED_DATA_SECTION/CODIF_DATA/DS_DATE_DISPATCH");
            submittingOffersDateExp = xPath.compile("/TED_EXPORT/CODED_DATA_SECTION/CODIF_DATA/DT_DATE_FOR_SUBMISSION");

            organizationNameExp = xPath.compile("/TED_EXPORT/FORM_SECTION/*[@LG='PL']/CONTRACTING_BODY/ADDRESS_CONTRACTING_BODY/OFFICIALNAME");
            organizationCityExp = xPath.compile("/TED_EXPORT/FORM_SECTION/*[@LG='PL']/CONTRACTING_BODY/ADDRESS_CONTRACTING_BODY/TOWN");
            organizationCountryExp = xPath.compile("/TED_EXPORT/FORM_SECTION/*[@LG='PL']/CONTRACTING_BODY/ADDRESS_CONTRACTING_BODY/COUNTRY/@VALUE");

            contractorNameExp = xPath.compile("/TED_EXPORT/FORM_SECTION/*[@LG='PL']/AWARD_CONTRACT/AWARDED_CONTRACT/CONTRACTORS/CONTRACTOR/ADDRESS_CONTRACTOR/OFFICIALNAME");
            contractorCityExp = xPath.compile("/TED_EXPORT/FORM_SECTION/*[@LG='PL']/AWARD_CONTRACT/AWARDED_CONTRACT/CONTRACTORS/CONTRACTOR/ADDRESS_CONTRACTOR/TOWN");
            contractorCountryExp = xPath.compile("/TED_EXPORT/FORM_SECTION/*[@LG='PL']/AWARD_CONTRACT/AWARDED_CONTRACT/CONTRACTORS/CONTRACTOR/ADDRESS_CONTRACTOR/COUNTRY");

            cpvCodeExp = xPath.compile("/TED_EXPORT/FORM_SECTION/*[@LG='PL']/OBJECT_CONTRACT/CPV_MAIN/CPV_CODE/@CODE");
            // @formatter:on
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
    }

    private final String defaultProcedure;
    private final String zoneId;

    public AdsPreparatorServiceImpl(@Value("${preparator.noticePrepared.default-procedure}") String defaultProcedure,
        @Value("${preparator.default.zoneId}") String zoneId) {

        this.defaultProcedure = defaultProcedure;
        this.zoneId = zoneId;
    }

    private OffsetDateTime parseDateForSubmission(String dateForSubmission) {
        LocalDateTime localDateTime = LocalDateTime
            .parse(dateForSubmission, DateTimeFormatter.ofPattern("yyyyMMdd hh:mm"));

        return OffsetDateTime.of(localDateTime, ZoneOffset.of(zoneId));
    }

    private OffsetDateTime parsePublicationDate(String dateDispatch) {
        LocalDateTime localDateTime = LocalDateTime
            .parse(dateDispatch, DateTimeFormatter.ofPattern("yyyyMMdd"));

        return OffsetDateTime.of(localDateTime, ZoneOffset.of(zoneId));
    }

    @Override
    public AdsPrepared prepare(Ads notice) throws Exception {
        if (notice.getContent() == null || notice.getContent().length == 0) {
            throw new Exception("Content of notice is empty");
        }

        AdsPrepared noticePrepared = new AdsPrepared();

        noticePrepared.setNd(notice.getNd());

        Document content = XMLUtil.convertToDocument(notice.getContent());

        Metadata metadata = new Metadata();
        noticePrepared.setMetadata(metadata);

        metadata.setClientType((String) clientTypeExp.evaluate(content, XPathConstants.STRING));
        metadata.setOrderType((String) orderTypeExp.evaluate(content, XPathConstants.STRING));
        metadata.setAdsType((String) noticeTypeExp.evaluate(content, XPathConstants.STRING));
        metadata.setAdsNumber((String) noticeNumberExp.evaluate(content, XPathConstants.STRING));
        metadata.setProcedureResult(defaultProcedure);
        metadata.setContractorName((String) contractorNameExp.evaluate(content, XPathConstants.STRING));
        metadata.setContractorCity((String) contractorCityExp.evaluate(content, XPathConstants.STRING));
        metadata.setContractorCountry((String) contractorCountryExp.evaluate(content, XPathConstants.STRING));
        metadata.setOrganizationName((String) organizationNameExp.evaluate(content, XPathConstants.STRING));
        metadata.setOrganizationCity((String) organizationCityExp.evaluate(content, XPathConstants.STRING));
        metadata.setOrganizationCountry((String) organizationCountryExp.evaluate(content, XPathConstants.STRING));
        metadata.setCpvCode((String) cpvCodeExp.evaluate(content, XPathConstants.STRING));

        metadata.setHtmlBody(Base64.getEncoder().encodeToString(notice.getContent()));

        return noticePrepared;
    }
}

